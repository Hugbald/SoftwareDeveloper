import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class SoftwareDeveloperInformationTest {

    @Test
    void shouldMergeValues() {
        SoftwareDeveloperInformation origin = new SoftwareDeveloperInformation(
                "Clément", "Java", "France", "34000", 29
        );
        SoftwareDeveloperInformation newInformations = new SoftwareDeveloperInformation(
                "Clément", "AngularJs", "France", "69000", 30
        );

        origin.merge(newInformations);

        assertThat(origin)
                .usingRecursiveComparison()
                .isEqualTo(new SoftwareDeveloperInformation("Clément", "AngularJs", "France", "69000", 30));
    }

    @Test
    void shouldSetValuesToNull() {
        SoftwareDeveloperInformation origin = new SoftwareDeveloperInformation(
                "Clément", "Java", "France", "34000", 29
        );
        SoftwareDeveloperInformation newInformations = new SoftwareDeveloperInformation(
                "Clément", "\"\"", "\"\"", "69000", 30
        );

        origin.merge(newInformations);

        assertThat(origin)
                .usingRecursiveComparison()
                .isEqualTo(new SoftwareDeveloperInformation("Clément", null, null, "69000", 30));
    }

    @Test
    void shouldThrowWhenNoAgeProvided() {

        SoftwareDeveloperInformation origin = new SoftwareDeveloperInformation(
                "Clément", "Java", "France", "34000", 29
        );
        SoftwareDeveloperInformation newInformations = new SoftwareDeveloperInformation(
                "Clément", "\"\"", "\"\"", "69000", null
        );

        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(()->origin.merge(newInformations));
    }

}
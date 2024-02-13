public class SoftwareDeveloperInformation {

    private String name;
    private String preferredLanguage;
    private String country;
    private String postalCode;
    private Integer age;

    public SoftwareDeveloperInformation(String name, String preferredLanguage, String country, String postalCode, Integer age) {
        this.name = name;
        this.preferredLanguage = preferredLanguage;
        this.country = country;
        this.postalCode = postalCode;
        this.age = age;
    }

    public void merge(SoftwareDeveloperInformation newInfo) {

        var c = newInfo.getCountry();
        this.setCountry(c);
        if (this.country != null && newInfo.getCountry().equals("\"\"")) {
            this.setCountry(null);
        }

        var l = (String) null;
        if (!newInfo.getPreferredLanguage().equals("\"\"")) {
            l = newInfo.getPreferredLanguage();
        }
        if (this.preferredLanguage != null && newInfo.getPreferredLanguage().equals("\"\"")) {
            l = null;
        }
        this.setPreferredLanguage(l);

        if(newInfo.getAge() == null) {
            throw new RuntimeException();
        }

        this.setName(newInfo.getName());
        this.setAge(newInfo.getAge());
        this.setPostalCode(newInfo.getPostalCode());

    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPreferredLanguage() {
        return preferredLanguage;
    }

    public void setPreferredLanguage(String preferredLanguage) {
        this.preferredLanguage = preferredLanguage;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

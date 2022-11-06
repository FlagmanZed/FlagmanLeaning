package HEStud.Enums;

public enum StudyProfile {

    MEDICINE("Медицина"),
    FOREIGN_LANGUAGE("Иностранные языки"),
    PHYSICAL_EDUCATION("Физическая культура");

    private final String profileName;

    private StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return this.profileName;
    }
}

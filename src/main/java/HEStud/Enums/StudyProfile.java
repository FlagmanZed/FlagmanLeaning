package HEStud.Enums;

public enum StudyProfile {

    MEDICINE("Медицина"),
    FOREIGN_LANGUAGE("Иностранные языки"),
    PHYSICAL_EDUCATION("Физическая культура");

    private String profileName;

    StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    @Override
    public String toString() {
        return "'" + profileName + '\'';
    }

}

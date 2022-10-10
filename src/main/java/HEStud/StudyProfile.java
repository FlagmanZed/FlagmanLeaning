package HEStud;

public enum StudyProfile {

    MEDICINE("Медицина"),
    FOREIGNLANGUAGE("Иностранные языки"),
    PHYSICALEDUCATION("Физическая культура");

    private String profileName;

    StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    @Override
    public String toString() {
        return "'" + profileName + '\'';
    }

}

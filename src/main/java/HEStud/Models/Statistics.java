package HEStud.Models;

import HEStud.Enums.StudyProfile;

public class Statistics {

    private StudyProfile learningProfile;
    private float avgExamScore;
    private int numberOfStudentsByProfile;
    private int numberOfUniversityByProfile;
    private String universityNames;

    public StudyProfile getLearningProfile() {
        return learningProfile;
    }

    public Statistics setLearningProfile(StudyProfile learningProfile) {
        this.learningProfile = learningProfile;
        return this;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public Statistics setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
        return this;
    }

    public int getNumberOfStudentsByProfile() {
        return numberOfStudentsByProfile;
    }

    public Statistics setNumberOfStudentsByProfile(int numberOfStudentsByProfile) {
        this.numberOfStudentsByProfile = numberOfStudentsByProfile;
        return this;
    }

    public int getNumberOfUniversityByProfile() {
        return numberOfUniversityByProfile;
    }

    public Statistics setNumberOfUniversityByProfile(int numberOfUniversityByProfile) {
        this.numberOfUniversityByProfile = numberOfUniversityByProfile;
        return this;
    }

    public String getUniversityNames() {
        return universityNames;
    }

    public Statistics setUniversityNames(String universityNames) {
        this.universityNames = universityNames;
        return this;
    }
}
package patient;

public enum Diagnoses {
    FLU,
    QUINSY,
    BRONCHITIS,
    PNEUMONIA,
    MIGRAINE;

    public static Diagnoses getRandomDiagnosis () {
        return Diagnoses.values ()[Patient.getRandom (0, 5)];
    }
}
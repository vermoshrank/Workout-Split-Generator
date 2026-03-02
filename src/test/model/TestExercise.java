package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.enums.Equipment;
import model.enums.MuscleGroup;
import model.enums.SplitType;
import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

@ExcludeFromJacocoGeneratedReport
public class TestExercise {
    private Exercise exercise;
    private ArrayList<MuscleGroup> targetMuscles;
    private ArrayList<SplitType> splits;

    @BeforeEach
    void setUp() {
        targetMuscles = new ArrayList<>();
        targetMuscles.add(MuscleGroup.CHEST);
        targetMuscles.add(MuscleGroup.TRICEPS);

        exercise = new Exercise(
                "Bench Press",
                targetMuscles,
                Equipment.BARBELL,
                135,
                2,
                6,
                10,
                1,
                1);
    }

    @Test
    void testConstructor() {
        assertEquals("Bench Press", exercise.getName());
        assertEquals(targetMuscles, exercise.getTargetMuscles());
        assertEquals(Equipment.BARBELL, exercise.getEquipmentType());
        assertEquals(135, exercise.getWeight());
        assertEquals(2, exercise.getSets());
        assertEquals(6, exercise.getMinReps());
        assertEquals(10, exercise.getMaxReps());
        assertEquals(1, exercise.getRir());
    }

    @Test
    void testToJsonName() {
        JSONObject json = exercise.toJson();
        assertEquals("Bench Press", json.getString("name"));
    }

    @Test
    void testToJsonEquipment() {
        JSONObject json = exercise.toJson();
        assertEquals("BARBELL", json.getString("equipmentType"));
    }

    @Test
    void testToJsonWeight() {
        JSONObject json = exercise.toJson();
        assertEquals(135, json.getInt("weight"));
    }

    @Test
    void testToJsonSets() {
        JSONObject json = exercise.toJson();
        assertEquals(2, json.getInt("sets"));
    }

    @Test
    void testToJsonMinReps() {
        JSONObject json = exercise.toJson();
        assertEquals(6, json.getInt("minReps"));
    }

    @Test
    void testToJsonMaxReps() {
        JSONObject json = exercise.toJson();
        assertEquals(10, json.getInt("maxReps"));
    }

    @Test
    void testToJsonRir() {
        JSONObject json = exercise.toJson();
        assertEquals(1, json.getInt("rir"));
    }

    @Test
    void testToJsonPriority() {
        JSONObject json = exercise.toJson();
        assertEquals(1, json.getInt("priority"));
    }

    @Test
    void testToJsonTargetMuscles() {
        JSONObject json = exercise.toJson();
        JSONArray muscles = json.getJSONArray("targetMuscles");
        assertEquals(2, muscles.length());
        assertEquals("CHEST", muscles.getString(0));
        assertEquals("TRICEPS", muscles.getString(1));
    }
}

package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.enums.GymType;
import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

@ExcludeFromJacocoGeneratedReport
public class TestGeneratorArguments {
    private GeneratorArguments generatorArguments;

    @BeforeEach
    void setUp() {
        generatorArguments = new GeneratorArguments(5, GymType.COMMERCIAL);
    }

    @Test
    void testConstructor() {
        assertEquals(5, generatorArguments.getTrainingDays());
        assertEquals(GymType.COMMERCIAL, generatorArguments.getGymType());
    }
}

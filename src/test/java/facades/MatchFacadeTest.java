package facades;

import TestEnvironment.TestEnvironment;
import entities.Matches;
import entities.Player;
import entities.Role;
import entities.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityNotFoundException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MatchFacadeTest extends TestEnvironment {
    private static RoleFacade facade;

    @BeforeAll
    public static void setUpClass() {
        TestEnvironment.setUpClass();
    }



}

package facades;

import TestEnvironment.TestEnvironment;
import entities.Role;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MatchFacadeTest extends TestEnvironment {
    private static RoleFacade facade;

    @BeforeAll
    public static void setUpClass() {
        TestEnvironment.setUpClass();
        facade = RoleFacade.getFacade(emf);
    }





}

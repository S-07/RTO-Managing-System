package com.rtofinalproject.registrations.LicenseRegisterModeltest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;

import org.junit.jupiter.api.Test;

import com.rtofinalproject.registrations.model.LicenseRegisterModel;

public class LicenseRegisterModelTest {

    @Test
    public void testLicenseRegisterModel() {
        LicenseRegisterModel license = new LicenseRegisterModel();

        // Test setters
        license.setLicense_id(1L);
        license.setFullName("John Doe");
        license.setAge("30");
        license.setBloodGroup("O+");
        license.setAadharNumber("123456789012");
        license.setMobileNumber("9876543210");
        license.setState("State");
        license.setAddress("123 Street, City, State");
        license.setDateOfIssue(new Date(System.currentTimeMillis()));
        license.setTypeOfVehicle("Car");
        license.setLicenseNumber("License123");

        // Test getters
        assertEquals(1L, license.getLicense_id());
        assertEquals("John Doe", license.getFullName());
        assertEquals("30", license.getAge());
        assertEquals("O+", license.getBloodGroup());
        assertEquals("123456789012", license.getAadharNumber());
        assertEquals("9876543210", license.getMobileNumber());
        assertEquals("State", license.getState());
        assertEquals("123 Street, City, State", license.getAddress());
        assertEquals("Car", license.getTypeOfVehicle());
        assertEquals("License123", license.getLicenseNumber());
    }
}

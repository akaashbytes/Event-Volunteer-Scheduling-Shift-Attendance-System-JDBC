package com.eventvol.util;

public class OverlappingShiftAssignmentException extends Exception {
    public String toString() {
        return "Volunteer already assigned to an overlapping shift.";
    }
}

package com.eventvol.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.eventvol.bean.Volunteer;
import com.eventvol.util.DBUtil;

public class VolunteerDAO {

    public Volunteer findVolunteer(String volunteerID) {
        try {
            Connection con = DBUtil.getDBConnection();
            String query = "SELECT * FROM VOLUNTEER_TBL WHERE VOLUNTEER_ID=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, volunteerID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Volunteer v = new Volunteer();
                v.setVolunteerID(rs.getString(1));
                v.setFullName(rs.getString(2));
                v.setSkillCategory(rs.getString(3));
                v.setPrimaryPhone(rs.getString(4));
                v.setEmail(rs.getString(5));
                v.setStatus(rs.getString(6));
                return v;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Volunteer> viewAllVolunteers() {
        List<Volunteer> list = new ArrayList<>();
        try {
            Connection con = DBUtil.getDBConnection();
            String query = "SELECT * FROM VOLUNTEER_TBL";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Volunteer v = new Volunteer();
                v.setVolunteerID(rs.getString(1));
                v.setFullName(rs.getString(2));
                v.setSkillCategory(rs.getString(3));
                v.setPrimaryPhone(rs.getString(4));
                v.setEmail(rs.getString(5));
                v.setStatus(rs.getString(6));
                list.add(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean insertVolunteer(Volunteer volunteer) {
        try {
            Connection con = DBUtil.getDBConnection();
            String query = "INSERT INTO VOLUNTEER_TBL VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, volunteer.getVolunteerID());
            ps.setString(2, volunteer.getFullName());
            ps.setString(3, volunteer.getSkillCategory());
            ps.setString(4, volunteer.getPrimaryPhone());
            ps.setString(5, volunteer.getEmail());
            ps.setString(6, volunteer.getStatus());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateVolunteerStatus(String volunteerID, String status) {
        try {
            Connection con = DBUtil.getDBConnection();
            String query = "UPDATE VOLUNTEER_TBL SET STATUS=? WHERE VOLUNTEER_ID=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, status);
            ps.setString(2, volunteerID);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteVolunteer(String volunteerID) {
        try {
            Connection con = DBUtil.getDBConnection();
            String query = "DELETE FROM VOLUNTEER_TBL WHERE VOLUNTEER_ID=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, volunteerID);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            return false;
        }
    }
}

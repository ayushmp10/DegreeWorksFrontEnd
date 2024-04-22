package model;

import java.util.ArrayList;
import java.util.UUID;

public class DegreeList {
    private static DegreeList degreeList;
    private ArrayList<Degree> degrees;

    private DegreeList() {
        degrees = DataLoader.getDegrees();
    }

    public static DegreeList getInstance() {
        if (degreeList == null) {
            degreeList = new DegreeList();
        }
        return degreeList;
    }

    public Degree getDegree(UUID id) {
        for (Degree degree : degrees) {
            if (degree.getUUID().equals(id)) {
                return degree;
            }
        }
        return null;
    }

    public void addDegree(Degree degree) {
        this.degrees.add(degree);
    }

    public ArrayList<Degree> getAllDegrees() {
        return this.degrees;
    }
}


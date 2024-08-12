package model.interfaces;

import model.enums.Degree;

public interface StudentInterface extends PersonInterface {
    String getUniversity();
    Degree getDegree();
}

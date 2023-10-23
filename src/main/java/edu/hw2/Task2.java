package edu.hw2;

public class Task2 {
    public class Rectangle {
        private int width;
        private int height;

        void setWidth(int width) {
            this.width = width;
        }

        void setHeight(int height) {
            this.height = height;
        }

        double area() {
            return width * height;
        }
    }

    public class Square extends Rectangle {
        private final String errorMessage = "One side can't be changed in a square";

        void setSide(int side) {
            super.setHeight(side);
            super.setWidth(side);
        }

        @Override
        void setWidth(int width) {
            throw new IllegalArgumentException(errorMessage);
        }

        @Override
        void setHeight(int height) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}





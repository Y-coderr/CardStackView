package com.example.cardstackview;

public class Profile {

        private String name;
        private int age;
        private String bio;
        private int imageResourceId;

        public Profile(String name, int age, String bio, int imageResourceId) {
            this.name = name;
            this.age = age;
            this.bio = bio;
            this.imageResourceId = imageResourceId;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getBio() {
            return bio;
        }

        public int getImageResourceId() {
            return imageResourceId;
        }
    }



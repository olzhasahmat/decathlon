package entity;

import enums.Decathlon;

import java.util.Optional;

public class AthletePerformance {
    private int decathlon = -1;
    private String name;

    private Double _100m;
    private Double longJump;
    private Double shotPut;
    private Double highJump;
    private Double _400m;

    private Double _110mHurdles;
    private Double discusThrow;
    private Double poleVault;
    private Double javelinThrow;
    private Integer _1500m;

    public String getName() {
        return name;
    }

    public int calculate100m() {
        return Optional.ofNullable(_100m).map(Decathlon._100_M::calculate).orElse(0);
    }

    public int calculateLongJump() {
        return Optional.ofNullable(longJump).map(Decathlon.LONG_JUMP::calculate).orElse(0);
    }

    public int calculateShotPut() {
        return Optional.ofNullable(shotPut).map(Decathlon.SHOT_PUT::calculate).orElse(0);
    }

    public int calculateHighJump() {
        return Optional.ofNullable(highJump).map(Decathlon.HIGH_JUMP::calculate).orElse(0);
    }

    public int calculate400m() {
        return Optional.ofNullable(_400m).map(Decathlon._400_M::calculate).orElse(0);
    }

    public int calculate110mHurdles() {
        return Optional.ofNullable(_110mHurdles).map(Decathlon._110_M_HURDLES::calculate).orElse(0);
    }

    public int calculateDiscusThrow() {
        return Optional.ofNullable(discusThrow).map(Decathlon.DISCUS_THROW::calculate).orElse(0);
    }

    public int calculatePoleVault() {
        return Optional.ofNullable(poleVault).map(Decathlon.POLE_VAULT::calculate).orElse(0);
    }

    public int calculateJavelinThrow() {
        return Optional.ofNullable(javelinThrow).map(Decathlon.JAVELIN_THROW::calculate).orElse(0);
    }

    public int calculate1500m() {
        return Optional.ofNullable(_1500m).map(Decathlon._1500_M::calculate).orElse(0);
    }

    private int calculateDecathlon() {
        return calculate100m()
                + calculateLongJump()
                + calculateShotPut()
                + calculateHighJump()
                + calculate400m()
                + calculate110mHurdles()
                + calculateDiscusThrow()
                + calculatePoleVault()
                + calculateJavelinThrow()
                + calculate1500m();
    }

    public int decathlon() {
        if (decathlon == -1) {
            decathlon = calculateDecathlon();
        }
        return decathlon;
    }

    public static class Builder {

        private final String name;

        private Double _100m = null;
        private Double longJump = null;
        private Double shotPut = null;
        private Double highJump = null;
        private Double _400m = null;
        private Double _110mHurdles = null;
        private Double discusThrow = null;
        private Double poleVault = null;
        private Double javelinThrow = null;
        private Integer _1500m = null;

        public Builder(String name) {
            this.name = name;
        }

        public Builder sprint100m(Double sprint100m) {
            this._100m = sprint100m;
            return this;
        }

        public Builder longJump(Double longJump) {
            this.longJump = longJump;
            return this;
        }

        public Builder shotPut(Double shotPut) {
            this.shotPut = shotPut;
            return this;
        }

        public Builder highJump(Double highJump) {
            this.highJump = highJump;
            return this;
        }

        public Builder sprint400m(Double _400m) {
            this._400m = _400m;
            return this;
        }

        public Builder sprint110mHurdles(Double _110mHurdles) {
            this._110mHurdles = _110mHurdles;
            return this;
        }

        public Builder discusThrow(Double discusThrow) {
            this.discusThrow = discusThrow;
            return this;
        }

        public Builder poleVault(Double poleVault) {
            this.poleVault = poleVault;
            return this;
        }

        public Builder javelinThrow(Double javelinThrow) {
            this.javelinThrow = javelinThrow;
            return this;
        }

        public Builder sprint1500m(Integer _1500m) {
            this._1500m = _1500m;
            return this;
        }

        public AthletePerformance build() {
            return new AthletePerformance(this);
        }
    }

    private AthletePerformance(Builder builder) {
        name = builder.name;
        _100m = builder._100m;
        longJump = builder.longJump;
        shotPut = builder.shotPut;
        highJump = builder.highJump;
        _400m = builder._400m;
        _110mHurdles = builder._110mHurdles;
        discusThrow = builder.discusThrow;
        poleVault = builder.poleVault;
        javelinThrow = builder.javelinThrow;
        _1500m = builder._1500m;
    }
}

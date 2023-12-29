package dev.efrxngg.geoproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Coordinate {

    private Double accuracy;
    private Double latitude;
    private Double longitude;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinate that = (Coordinate) o;

        if (!Objects.equals(accuracy, that.accuracy)) return false;
        if (!Objects.equals(latitude, that.latitude)) return false;
        return Objects.equals(longitude, that.longitude);
    }

    @Override
    public int hashCode() {
        int result = accuracy != null ? accuracy.hashCode() : 0;
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        return result;
    }
}

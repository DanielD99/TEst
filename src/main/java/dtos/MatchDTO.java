package dtos;

import entities.Match;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

/**
 * A DTO for the {@link entities.Match} entity
 */
public class MatchDTO implements Serializable {
    private final Integer id;
    @Size(max = 45)
    private final String opponentTeam;
    @Size(max = 45)
    private final String judge;
    @Size(max = 45)
    private final String type;
    private final Byte inDoors;
    @NotNull
    private final LocationInnerDTO location;
    private final Set<PlayerInnerDTO> players;

    public MatchDTO(Integer id, String opponentTeam, String judge, String type, Byte inDoors, LocationInnerDTO location, Set<PlayerInnerDTO> players) {
        this.id = id;
        this.opponentTeam = opponentTeam;
        this.judge = judge;
        this.type = type;
        this.inDoors = inDoors;
        this.location = location;
        this.players = players;
    }

    public MatchDTO(Match match) {
        this.id = match.getId();
        this.opponentTeam = match.getOpponentTeam();
        this.judge = match.getJudge();
        this.type = match.getType();
        this.inDoors = match.getInDoors();

    }

    public Integer getId() {
        return id;
    }

    public String getOpponentTeam() {
        return opponentTeam;
    }

    public String getJudge() {
        return judge;
    }

    public String getType() {
        return type;
    }

    public Byte getInDoors() {
        return inDoors;
    }

    public LocationInnerDTO getLocation() {
        return location;
    }

    public Set<PlayerInnerDTO> getPlayers() {
        return players;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "opponentTeam = " + opponentTeam + ", " +
                "judge = " + judge + ", " +
                "type = " + type + ", " +
                "inDoors = " + inDoors + ", " +
                "location = " + location + ", " +
                "players = " + players + ")";
    }

    /**
     * A DTO for the {@link entities.Location} entity
     */
    public static class LocationInnerDTO implements Serializable {
        private final Integer id;
        @Size(max = 45)
        private final String address;
        @Size(max = 45)
        private final String city;
        @Size(max = 45)
        private final String condition;

        public LocationInnerDTO(Integer id, String address, String city, String condition) {
            this.id = id;
            this.address = address;
            this.city = city;
            this.condition = condition;
        }

        public Integer getId() {
            return id;
        }

        public String getAddress() {
            return address;
        }

        public String getCity() {
            return city;
        }

        public String getCondition() {
            return condition;
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + "(" +
                    "id = " + id + ", " +
                    "address = " + address + ", " +
                    "city = " + city + ", " +
                    "condition = " + condition + ")";
        }
    }

    /**
     * A DTO for the {@link entities.Player} entity
     */
    public static class PlayerInnerDTO implements Serializable {
        private final Integer id;
        @Size(max = 45)
        private final String name;
        @Size(max = 45)
        private final String phone;
        @Size(max = 45)
        private final String email;
        private final Byte status;

        public PlayerInnerDTO(Integer id, String name, String phone, String email, Byte status) {
            this.id = id;
            this.name = name;
            this.phone = phone;
            this.email = email;
            this.status = status;
        }

        public Integer getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getPhone() {
            return phone;
        }

        public String getEmail() {
            return email;
        }

        public Byte getStatus() {
            return status;
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + "(" +
                    "id = " + id + ", " +
                    "name = " + name + ", " +
                    "phone = " + phone + ", " +
                    "email = " + email + ", " +
                    "status = " + status + ")";
        }
    }
}
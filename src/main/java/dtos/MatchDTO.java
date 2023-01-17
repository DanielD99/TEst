package dtos;

import entities.Location;
import entities.Matches;
import entities.Player;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A DTO for the {@link Matches} entity
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
    private final List<PlayerInnerDTO> players = new ArrayList<>();

    public MatchDTO(Integer id, String opponentTeam, String judge, String type, Byte inDoors, LocationInnerDTO location) {
        this.id = id;
        this.opponentTeam = opponentTeam;
        this.judge = judge;
        this.type = type;
        this.inDoors = inDoors;
        this.location = location;

    }

    public MatchDTO(Matches match) {
        this.id = match.getId();
        this.opponentTeam = match.getOpponentTeam();
        this.judge = match.getJudge();
        this.type = match.getType();
        this.inDoors = match.getInDoors();
        this.location = new LocationInnerDTO((match.getLocation()));
        match.getPlayers().forEach(player -> {
            players.add(new PlayerInnerDTO(player));
        });
    }

    public static List<MatchDTO> getDTOs(List<Matches> matches) {

        List<MatchDTO> MatchDTOList = new ArrayList<>();
        matches.forEach(match -> {
            MatchDTOList.add(new MatchDTO(match));
        });
        return MatchDTOList;
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

    public List<PlayerInnerDTO> getPlayers() {
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
        private final String address;
        private final String city;
        private final String weather;

        public LocationInnerDTO(Integer id, String address, String city, String weather) {
            this.id = id;
            this.address = address;
            this.city = city;
            this.weather = weather;
        }

        public LocationInnerDTO(Location location){

            this.id = location.getId();
            this.address = location.getAddress();
            this.city = location.getCity();
            this.weather = location.getWeather();
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

        public String getWeather() {
            return weather;
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + "(" +
                    "id = " + id + ", " +
                    "address = " + address + ", " +
                    "city = " + city + ", " +
                    "weather = " + weather + ")";
        }
    }

    /**
     * A DTO for the {@link entities.Player} entity
     */
    public static class PlayerInnerDTO implements Serializable {
        private final Integer id;
        private final String name;
        private final String phone;
        private final String email;
        private final String status;

        public PlayerInnerDTO(Integer id, String name, String phone, String email, String status) {
            this.id = id;
            this.name = name;
            this.phone = phone;
            this.email = email;
            this.status = status;
        }

        public PlayerInnerDTO(Player player){
            this.id = player.getId();
            this.name = player.getName();
            this.phone = player.getPhone();
            this.email = player.getEmail();
            this.status = player.getStatus();

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

        public String getStatus() {
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
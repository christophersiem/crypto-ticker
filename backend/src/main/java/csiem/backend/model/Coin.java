package csiem.backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Coin {

    private String name;
    private CurrentPrice currentPrice;
    private String imageUrl;
    private LocalDateTime lastUpdated;
}

package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DailyFortune {
    private String dateLabel; // ex) "11/27 수"
    private int day;          // ex) 27 (달력용)
    private String summary;   // 짧은 운세
}

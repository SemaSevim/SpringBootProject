package de.semasevim.IlService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor // constructorları compile anında meaven üzerinde otomatik oluşturur
public class Il {

    @Id
    private String id;

    private Date createDate = new Date();
    private String name;


}

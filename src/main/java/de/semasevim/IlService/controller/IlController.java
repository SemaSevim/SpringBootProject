package de.semasevim.IlService.controller;

import de.semasevim.IlService.model.Il;
import de.semasevim.IlService.repository.IlRepository;
import de.semasevim.IlService.service.IlService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/iller") //url
@AllArgsConstructor
public class IlController {

    private final IlService ilService;
    /* AllArgsConstructer ile otamatik oluşturulur LOMBOK
    public IlController(IlService ilService){
        this.ilService = ilService;
    }*/

    @GetMapping
    public ResponseEntity<List<Il>> getIller(){
        return new ResponseEntity<>(ilService.getIller() , HttpStatus.OK); //
    }

    @GetMapping("/{id}")
    public ResponseEntity<Il> getIl(@PathVariable String id){
        /*
        for(int i=0; i<iller.size(); i++){
            Il il = iller.get(i);
            if (il.getId().equals(id)){
                result = il;
            }
        }
        if(result == null){
            throw new RuntimeException("Il not found");
        } */
        return new ResponseEntity<>(getIlById(id), HttpStatus.OK);

    }
    @PostMapping //il ekleme
    public ResponseEntity<Il> createIl(@RequestBody Il newIL) { //ili döndürür,burada objenin yalnız id// sini de döndürebilirsin string ile
        return new ResponseEntity<>(ilService.createIl(newIL), HttpStatus.CREATED);

    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> getIl(@PathVariable String id, @RequestBody Il newIL){
        Il oldIl = getIlById(id);
        oldIl.setName(newIL.getName());
        oldIl.setCreateDate(new Date());
        ilService.updateIl(id, newIL);

        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIl(@PathVariable String id){
        ilService.deleteIl(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private Il getIlById (String id){
        return ilService.getIlById(id);


    }

}

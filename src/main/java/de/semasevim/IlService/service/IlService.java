package de.semasevim.IlService.service;

import de.semasevim.IlService.model.Il;
import de.semasevim.IlService.repository.IlRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class IlService {

    private final IlRepository ilRepository;
    public List<Il> getIller() {
        return ilRepository.findAll();

    }

    public Il createIl(Il newIL) {
        //newIL.setCreateDate(new Date());  Il consturecterda yapıyoruz bunu
        return ilRepository.save(newIL);
    }

    public void deleteIl(String id) {
        ilRepository.deleteById(id);
    }

    public Il getIlById(String id) {
        return ilRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Il Not Found"));
    }

    public void updateIl(String id, Il newIL) {
        Il oldIl = getIlById(id);
        oldIl.setName(newIL.getName());
        ilRepository.save(oldIl);
    }
}

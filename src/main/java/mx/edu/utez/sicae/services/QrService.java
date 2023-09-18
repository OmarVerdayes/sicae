package mx.edu.utez.sicae.services;

import mx.edu.utez.sicae.controllers.Qr.dtos.QrResponse;
import mx.edu.utez.sicae.models.asistence.Asistence;
import mx.edu.utez.sicae.models.asistence.AsistenceRepository;
import mx.edu.utez.sicae.models.qr.Qr;
import mx.edu.utez.sicae.models.qr.QrRepository;
import mx.edu.utez.sicae.models.student.Student;
import mx.edu.utez.sicae.models.student.StudentRepository;
import mx.edu.utez.sicae.models.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

@Service
@Transactional
public class QrService {
    @Autowired
    private QrRepository repository;
    @Autowired
    private AsistenceRepository asistenceRepository;
    @Autowired
    private StudentRepository studentRepository;

    @Transactional(readOnly = true)
    public CustomResponse<List<QrResponse>> getAll(){
        List<QrResponse> qrList = new ArrayList<>();
        List<Qr>qrs= this.repository.findAll();
        for(int i=0;i<qrs.size();i++){
            QrResponse qr=new QrResponse().castToResponse(qrs.get(i));
            qrList.add(qr);
        }
        return new CustomResponse<>(qrList,false,200,"OK");
    }

   /* @Transactional(readOnly = true)
    public CustomResponse<Qr> delete(Long id){
        return new CustomResponse<>(this.repository.findById(id).get(),false,200,"OK");
    }*/
   @Transactional(readOnly = true)
   public CustomResponse<QrResponse> getOne(Long id){
       QrResponse qr= new QrResponse().castToResponse(this.repository.findById(id).get());
       return new CustomResponse<>(qr,false,200,"OK");
   }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Qr>insert(Qr qr){
        qr=this.repository.saveAndFlush(qr);
        List<Student> listIdSudents=this.studentRepository.students(qr.getClas().getGroup().getId());
        for(int i=0;i<listIdSudents.size();i++){
            Asistence asistence= new Asistence();
            asistence.setDate(qr.getDate());
            asistence.setQr(qr);
            asistence.setStatus(0);
            asistence.setStudent(listIdSudents.get(i));
            asistence=this.asistenceRepository.saveAndFlush(asistence);
            //this.asistenceRepository.insert(listIdSudents.get(i).getId(),asistence.getId());
        }

        return new CustomResponse<>(qr,false,200,"Qr registrado correctamente");
    }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Qr> update(Qr qr){
        return new CustomResponse<>(
                this.repository.saveAndFlush(qr),false,200,"Qr actualizado coreectamente"
        );
    }

   @Transactional(rollbackFor = {SQLException.class})

    public CustomResponse<Boolean> changeStatus(Qr qr){
        if(!this.repository.existsById(qr.getId()))
            return new CustomResponse<>(null,true,400,"La subcategoria no existe");
        return new CustomResponse<>(
                this.repository.updateById(qr.getStatus(),qr.getId()),false,200,"Qr actualizada correctamente"
        );
    }
}

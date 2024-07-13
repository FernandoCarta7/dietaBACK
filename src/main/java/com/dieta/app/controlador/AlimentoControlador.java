package com.dieta.app.controlador;

import com.dieta.app.modelo.Alimento;
import com.dieta.app.servicio.AlimentoServicio;
import org.apache.tomcat.util.buf.Utf8Encoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.beans.Encoder;
import java.io.*;
import java.util.List;
import java.lang.String;
import java.util.stream.Collectors;

import org.apache.commons.csv.*;

@RestController
@RequestMapping("dieta-app")
@CrossOrigin(value = "http://localhost:4200")
public class AlimentoControlador {
    private static final Logger logger = LoggerFactory.getLogger(AlimentoControlador.class);

    @Autowired
    private AlimentoServicio alimentoServicio;

    //LISTAR ALIMENTOS
    @GetMapping("/alimentos")
    public List<Alimento> obtenerAlimento(){
        List<Alimento> listaAlimentos = this.alimentoServicio.listarAlimentos();

        logger.info("Listar alimentos");
        return listaAlimentos;
    }

    @PostMapping("/alimentos/upload")
    public void cargaAlimentosCSV(@RequestParam("file")MultipartFile file) throws IOException {
        if(file.isEmpty()){
            this.logger.warn("Archivo vacio");
        }

        try(BufferedReader buffer = new BufferedReader(new InputStreamReader(file.getInputStream()))){
            String content = buffer.lines().collect(Collectors.joining("\n"));
            List<String> listaAlimentos = content.lines().toList();
            List<Alimento> alimentoList = this.alimentoServicio.listarAlimentos();
            
            for (int i = 1; i < listaAlimentos.size(); i++) {
                Alimento alimento = new Alimento();
                String [] linea = listaAlimentos.get(i).split(",");
                alimento.setNombre(linea[0]);
                alimento.setDescripcion(linea[1]);
                alimento.setCategoria(linea[2]);
                alimento.setCalorias(Integer.parseInt(linea[3]));
                alimentoServicio.guardarAlimento(alimento);
            }

            logger.info("Carga de archivo");
        }catch (IOException e){
            logger.info(e.getMessage());
        }

    }


}

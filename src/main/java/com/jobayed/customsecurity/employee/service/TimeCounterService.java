package com.jobayed.customsecurity.employee.service;

import com.jobayed.customsecurity.baserepository.IBaseRepository;
import com.jobayed.customsecurity.employee.model.TimeCounter;
import com.jobayed.customsecurity.employee.repository.TimeCounterRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TimeCounterService {
    private final TimeCounterRepository timeCounterRepository;
    private final IBaseRepository repository;

    public TimeCounter save(TimeCounter timeCounter) {
        TimeCounter t = timeCounterRepository.findByEmployeeId(timeCounter.getEmployeeId()).orElse(null);

        if(t != null){
            t.setTimeCountInMin(t.getTimeCountInMin()+5);
            return timeCounterRepository.save(t);
        }
        return timeCounterRepository.save(timeCounter);
    }

    public TimeCounter getByEmployeeId(String employeeId){
        return timeCounterRepository.findByEmployeeId(employeeId).orElse(null);
    }

    @Scheduled(cron = "0/20 * * * * *") //Every 5 mins
    public void scheduledTask(){
        log.info("Time: "+new Date().toLocaleString());
        try {

            File file = new File("src/main/resources/xmldata/data_single.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(TimeCounter.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            //List<TimeCounter> que= (List<TimeCounter>) jaxbUnmarshaller.unmarshal(file);

            TimeCounter timeCounter = (TimeCounter) jaxbUnmarshaller.unmarshal(file);

            System.out.println(timeCounter);

            this.save(timeCounter);
            /***************************************************************/

            JAXBContext jc = JAXBContext.newInstance(TimeCounter.class);

            XMLInputFactory xif = XMLInputFactory.newFactory();
            StreamSource xml = new StreamSource("src/main/resources/xmldata/data.xml");
            XMLStreamReader xsr = xif.createXMLStreamReader(xml);

            List<TimeCounter> timeCounters = new ArrayList<TimeCounter>();
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            while(xsr.getEventType() != XMLStreamReader.END_DOCUMENT) {
                if(xsr.isStartElement() && "timeCounter".equals(xsr.getLocalName())) {
                    timeCounter = (TimeCounter) unmarshaller.unmarshal(xsr);
                    timeCounters.add(timeCounter);

                    System.out.println(timeCounter);
                    this.save(timeCounter);
                }
                xsr.next();
            }

            System.out.println(timeCounters.size());

        } catch (JAXBException | XMLStreamException e) {
            e.printStackTrace();
        }
    }
}

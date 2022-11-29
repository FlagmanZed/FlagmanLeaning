package HEStud.FileInstrument;

import HEStud.Models.MaxInfo;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WriteXml {
    private static final Logger logger = Logger.getLogger(WriteXml.class.getName());

    private WriteXml() {
    }

    public static void generateXmlReq(MaxInfo maxInfo) {

        try {
            logger.log(Level.INFO, "XML Сортировка началась");

            JAXBContext jaxbContext = JAXBContext.newInstance(MaxInfo.class);

            Marshaller marshaller = jaxbContext.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            try {
                Files.createDirectory(Paths.get("xmlReqs"));
                logger.log(Level.INFO, "Каталог создан успешно");
            } catch (IOException ioEx) {
                logger.log(Level.FINE, "Каталог уже существует", ioEx);
            }
            File requestFile = new File("xmlReqs/infoReq" + new Date().getTime() + ".xml");

            marshaller.marshal(maxInfo, requestFile);
        } catch (JAXBException jaxbEx) {
            logger.log(Level.SEVERE, "Сортировка не удалась", jaxbEx);
            return;
        }

        logger.log(Level.INFO, "Сортировка выполнена успешно");
    }
}

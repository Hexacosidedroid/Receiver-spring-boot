import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlElementWrapper

@XmlAccessorType(XmlAccessType.FIELD)
data class StudentXml(
    @XmlElement(name = "name")
    var name: String? = null,
    @XmlElementWrapper(name = "hobbies")
    val hobby: MutableList<String> = mutableListOf()
)

import javax.xml.bind.annotation.*

@XmlRootElement(name = "department")
@XmlAccessorType(XmlAccessType.FIELD)
data class DepartmentXml(
    @XmlElement(name = "room")
    var room: String? = null,
    @XmlElementWrapper(name = "students")
    val student: MutableList<StudentXml> = mutableListOf()
)
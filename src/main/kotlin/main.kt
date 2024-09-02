import java.lang.Exception
import java.lang.IllegalArgumentException
import kotlin.math.E


class Course (val name: CourseName ) {
    var grade: Double? = null
        set(value) {
            if (value == null || value < 1.0 || value > 6.0) {
                throw Exception ("Invalid")
            } else {
                field = value
            }
        }
    val passed: Boolean
        get() {
            if (grade!! <= 4.0) {
            print("($name passed) ")
                return true
            }else print("($name failed) ")
            return false
        }

    override fun toString(): String {
        return name.toString()
    }
}

class Student(val name : String, var age : Int) {
    var courses = mutableListOf<Course>()

    fun addCourse(course: Course) {
        if (courses.contains(course)) {
            throw IllegalArgumentException("course ${course.name} is already existing")
        } else courses.add(course)
    }

    override fun toString(): String {
        return name
    }

    fun averageGrade(): Double {
        if (courses.isEmpty())
            throw IllegalStateException("there are no courses")
        else {
            val sum = courses.sumOf { it.grade!!.toDouble() }
            return sum / courses.size
        }
    }
    }
enum class CourseName {MATH,
                      CHEMISTRY,
                      ENGLISH}

class Studentclass (val id : String) {
    var students = mutableListOf<Student>()


        fun addstudent(student: Student) {
    if (students.contains(student))
        throw IllegalArgumentException("student is already in class")
    else {
        students.add(student)
    }
}
    fun getAmountOfStudentWithLetter (char: Char) : Int {
    var count = 0
        for ( student in students) {
            if (student.name.startsWith(char))
                count++

        }
        return count
    }
}
fun main() {

    val math = Course(CourseName.MATH)
    math.grade = 5.0

    val english = Course(CourseName.ENGLISH)
    english.grade = 3.0

    val chemistry = Course(CourseName.CHEMISTRY)
    chemistry.grade = 6.0 // invalide

    val student1 = Student("Erika Mustermann ", 21)

    val student2 = Student("Max Mustermann ", 21)

    val student3 = Student("Maria", 23)

    student1.addCourse(math)
    student1.addCourse(english)
    student2.addCourse(chemistry)


    println("Student: "+student1+" has the courses: "+student1.courses)
    println("Student: "+student2+"has the courses: "+student2.courses)
    println("Student: "+student1+"average grade is: "+student1.averageGrade())


    val studentClass = Studentclass("10b")
    studentClass.addstudent(student1)
    studentClass.addstudent(student2)
    studentClass.addstudent(student3)

    println("Students of the class "+studentClass.id+" are: "+studentClass.students)

    println(studentClass.getAmountOfStudentWithLetter('M'))
}

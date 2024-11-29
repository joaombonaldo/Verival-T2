package com.ensportive;

import com.ensportive.teachers.TeacherRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.ensportive.courses.CourseEntity;
import com.ensportive.courses.CourseRepository;
import com.ensportive.courses.CourseService;
import com.ensportive.enums.Level;
import com.ensportive.enums.PlanType;
import com.ensportive.enums.Sport;
import com.ensportive.lessons.LessonEntity;
import com.ensportive.lessons.LessonRepository;
import com.ensportive.lessons.LessonService;
import com.ensportive.teachers.TeacherEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.DayOfWeek;
import java.util.List;
import java.util.Random;

@SpringBootTest(classes = EnsportiveApplication.class)
@ActiveProfiles("dev") // Certifique-se de que você tem um perfil de testes configurado
public class LessonServiceIntegrationTest {

    @Autowired
    private LessonService lessonService;

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private CourseRepository courseRepository;  // Adiciona a injeção do CourseRepository

    @Autowired
    private TeacherRepository teacherRepository;

    private CourseEntity courseEntity;
    private TeacherEntity teacher ;

    public int idCourse;

    @BeforeEach
    public void setup() {
        Random random = new Random();
        teacher = new TeacherEntity();
        teacher.setName("Teacher ");
        teacher.setSport(Sport.TENNIS);
        teacher.setEmail(random.nextInt(1000000000) + "");
        teacher.setCellPhone(random.nextInt(1000000000) + "");
        teacher.setLessons(null);
        courseEntity = new CourseEntity();
        courseEntity.setSport(Sport.TENNIS);
        courseEntity.setLevel(Level.BEGINNER_1);
        courseEntity.setPlanType(PlanType.JUNIOR);
        courseEntity.setStudentsSize(20);
        courseEntity.setUniqueLesson(false);
        courseEntity.setWeekDay(DayOfWeek.MONDAY);
        courseEntity.setHour(LocalTime.of(10, 0));
        courseEntity.setTeacher(teacher);
        courseEntity.setCourt(1L);
    }

    @Test
    public void testCreateFirstLessons() {
        teacherRepository.save(teacher);

        var result = courseRepository.save(courseEntity);

        lessonService.createFirstLessons(courseEntity);

        List<LessonEntity> lessons = lessonRepository.findByCourseId(result.getId());
        assertNotNull(lessons);
        assertEquals(12, lessons.size(), "Deve ter criado 12 aulas");

        LocalDateTime expectedLessonDate = LocalDate.now().with(courseEntity.getWeekDay()).atTime(courseEntity.getHour());
        for (int i = 0; i < lessons.size(); i++) {
            LessonEntity lesson = lessons.get(i);
            assertEquals(courseEntity.getStudentsSize(), lesson.getSpot(), "O número de vagas deve ser igual ao do curso");
            assertNotNull(lesson.getTeacher(), "A aula deve ter um professor atribuído");
            assertTrue(lesson.getDate().isEqual(expectedLessonDate.plusWeeks(i+1)),
                       "A data da aula deve ser correta. Esperado: " + expectedLessonDate.plusWeeks(i) + " mas foi: " + lesson.getDate());
        }
    }
}

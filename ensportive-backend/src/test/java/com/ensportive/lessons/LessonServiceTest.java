package com.ensportive.lessons;

import com.ensportive.courses.CourseEntity;
import com.ensportive.teachers.TeacherEntity;
import com.ensportive.teachers.TeacherRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LessonServiceTest {

    @Mock
    private LessonRepository lessonRepository;

    @Mock
    private TeacherRepository teacherRepository;

    @Mock
    private LessonMapper lessonMapper;

    @InjectMocks
    private LessonService lessonService;

    private CourseEntity courseEntity;
    private TeacherEntity teacherEntity;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Setup mock data for CourseEntity and TeacherEntity
        courseEntity = new CourseEntity();
        courseEntity.setId(1L);
        courseEntity.setHour(LocalTime.of(10, 0));
        courseEntity.setWeekDay(DayOfWeek.MONDAY);
        courseEntity.setStudentsSize(10);
        
        teacherEntity = new TeacherEntity();
        teacherEntity.setId(1L);
    }

    @Test
    void testCreateFirstLessonsSuccessfully() {
        // Arrange
        when(lessonRepository.saveAll(anyList())).thenReturn(List.of(new LessonEntity()));
        
        // Act
        lessonService.createFirstLessons(courseEntity);

        // Assert
        verify(lessonRepository, times(12)).save(any(LessonEntity.class));  // Verifica se 12 aulas foram criadas
    }

    @Test
    void testCreateFirstLessonsWithTeacher() {
        // Arrange
        courseEntity.setTeacher(teacherEntity);
        when(lessonRepository.saveAll(anyList())).thenReturn(List.of(new LessonEntity()));
        
        // Act
        lessonService.createFirstLessons(courseEntity);

        // Assert
        verify(lessonRepository, times(12)).save(any(LessonEntity.class));  // Verifica se 12 aulas foram criadas
        // Verifica se o professor foi atribuído às aulas
        verify(lessonRepository, times(12)).save(argThat(lesson -> lesson.getTeacher() == teacherEntity));
    }

    @Test
    void testCreateFirstLessonsWithNoNextLessonDate() {
        // Arrange
        courseEntity.setWeekDay(DayOfWeek.FRIDAY);
        courseEntity.setHour(LocalTime.of(18, 0));
        when(lessonRepository.saveAll(anyList())).thenReturn(List.of(new LessonEntity()));

        // Act
        lessonService.createFirstLessons(courseEntity);

        // Assert
        verify(lessonRepository, times(12)).save(any(LessonEntity.class));  // Verifica se 12 aulas foram criadas
    }

    @Test
    void testCreateFirstLessonsWithInvalidNextLessonDate() {
        // Arrange
        courseEntity.setWeekDay(DayOfWeek.MONDAY);
        courseEntity.setHour(LocalTime.of(9, 0));
        courseEntity.setStudentsSize(5);
        when(lessonRepository.saveAll(anyList())).thenReturn(List.of(new LessonEntity()));

        // Act
        lessonService.createFirstLessons(courseEntity);

        // Assert
        verify(lessonRepository, times(12)).save(any(LessonEntity.class));  // Verifica se 12 aulas foram criadas
    }

    @Test
    void testCreateFirstLessonsWithEmptyCourse() {
        // Arrange
        CourseEntity emptyCourse = new CourseEntity();
        emptyCourse.setHour(null);  // Missing hour
        emptyCourse.setWeekDay(null);  // Missing weekday
        emptyCourse.setStudentsSize(0);  // No students
        
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            lessonService.createFirstLessons(emptyCourse);
        });
    }
}

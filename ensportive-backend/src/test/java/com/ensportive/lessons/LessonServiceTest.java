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
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.argThat;
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

        // Setup mock data pra CourseEntity e TeacherEntity
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
        when(lessonRepository.saveAll(anyList())).thenReturn(List.of(new LessonEntity()));
        
        lessonService.createFirstLessons(courseEntity);
    
        verify(lessonRepository, times(1)).saveAll(anyList());  // Verifica se saveAll foi chamado uma vez
        verify(lessonRepository, times(1)).saveAll(argThat(list -> 
            list instanceof List && ((List<?>) list).size() == 12));  // Verifica se a lista contém 12 aulas
    }    


    @Test
    void testCreateFirstLessonsWithTeacher() {
        courseEntity.setTeacher(teacherEntity);
        when(lessonRepository.saveAll(anyList())).thenReturn(List.of(new LessonEntity()));  // Mock para salvar todas as aulas
    
        lessonService.createFirstLessons(courseEntity);
    
        // Verifica se o saveAll foi chamado uma vez com uma lista de 12 aulas
        verify(lessonRepository, times(1)).saveAll(argThat(lessons -> {
            // Converte o Iterable para List e verifica o tamanho
            return ((List<LessonEntity>) lessons).size() == 12;
        }));  
    
        // Verifica se o professor foi atribuído às aulas
        verify(lessonRepository, times(1)).saveAll(argThat(lessons -> {
            // Converte o Iterable para List e verifica se todas as aulas possuem o mesmo professor
            return ((List<LessonEntity>) lessons).stream().allMatch(lesson -> lesson.getTeacher().equals(teacherEntity));
        }));
    }       


    @Test
    void testCreateFirstLessonsWithNoNextLessonDate() {
        courseEntity.setWeekDay(DayOfWeek.FRIDAY);
        courseEntity.setHour(LocalTime.of(18, 0));
        when(lessonRepository.saveAll(anyList())).thenReturn(List.of(new LessonEntity()));
    
        lessonService.createFirstLessons(courseEntity);
    
        // Verifica se saveAll foi chamado uma vez com uma lista de 12 aulas
        verify(lessonRepository, times(1)).saveAll(argThat(lessons -> {
            // Verifica se a lista tem 12 aulas
            return ((List<LessonEntity>) lessons).size() == 12;
        }));
    }    

    @Test
    void testCreateFirstLessonsWithInvalidNextLessonDate() {
        courseEntity.setWeekDay(DayOfWeek.MONDAY);
        courseEntity.setHour(LocalTime.of(9, 0));
        courseEntity.setStudentsSize(5);
        when(lessonRepository.saveAll(anyList())).thenReturn(List.of(new LessonEntity()));
    
        lessonService.createFirstLessons(courseEntity);
    
        // Verifica se saveAll foi chamado uma vez com uma lista de 12 aulas
        verify(lessonRepository, times(1)).saveAll(argThat(lessons -> {
            // Verifica se a lista tem 12 aulas
            return ((List<LessonEntity>) lessons).size() == 12;
        }));
    }      

    @Test
    void testCreateFirstLessonsWithEmptyCourse() {
        CourseEntity emptyCourse = new CourseEntity();
        emptyCourse.setHour(null);  // Missing hour
        emptyCourse.setWeekDay(null);  // Missing weekday
        emptyCourse.setStudentsSize(0);  // No students
        
        assertThrows(IllegalArgumentException.class, () -> {
            lessonService.createFirstLessons(emptyCourse);
        });
    }    
}

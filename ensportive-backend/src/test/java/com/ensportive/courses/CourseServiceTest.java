package com.ensportive.courses;

import com.ensportive.courses.dtos.CourseRequestDTO;
import com.ensportive.enums.Level;
import com.ensportive.enums.PlanType;
import com.ensportive.enums.Sport;
import com.ensportive.lessons.LessonService;
import com.ensportive.teachers.TeacherEntity;
import com.ensportive.teachers.TeacherRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import java.time.DayOfWeek;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CourseServiceTest {

    @Mock
    private CourseRepository courseRepository;

    @Mock
    private LessonService lessonService;

    @Mock
    private TeacherRepository teacherRepository;

    @InjectMocks
    private CourseService courseService;

    private CourseRequestDTO courseRequestDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Setup data for CourseRequestDTO
        courseRequestDTO = new CourseRequestDTO(
            Sport.TENNIS, 
            Level.ADVANCED, 
            PlanType.GROUP, 
            4, 
            LocalTime.of(9, 0), 
            DayOfWeek.MONDAY, 
            null, 
            false, 
            1L, 
            1L, 
            new Long[] {1L, 2L, 3L, 4L}
        );
    }

    @Test
    void testCreateCourseSuccessfully() {
        // Arrange
        CourseEntity courseEntity = new CourseEntity();
        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setId(1L);

        // Mocking dependencies
        when(courseRepository.save(any(CourseEntity.class))).thenReturn(courseEntity);
        when(teacherRepository.findById(anyLong())).thenReturn(java.util.Optional.of(teacherEntity));

        // Act
        Long courseId = courseService.create(courseRequestDTO);

        // Assert
        assertNotNull(courseId, "Course ID should not be null");
        verify(courseRepository, times(1)).save(any(CourseEntity.class));
        verify(lessonService, times(1)).createFirstLessons(any(CourseEntity.class));
    }

    @Test
    void testCreateCourseWithNullHour() {
        // Arrange
        CourseRequestDTO invalidRequest = new CourseRequestDTO(
            Sport.TENNIS, 
            Level.ADVANCED, 
            PlanType.GROUP, 
            4, 
            null,  // Hour is null
            DayOfWeek.MONDAY, 
            null, 
            false, 
            1L, 
            1L, 
            new Long[] {1L, 2L, 3L, 4L}
        );

        // Act & Assert
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            courseService.create(invalidRequest);
        });
        assertEquals("Hour is required", thrown.getMessage());
    }

    @Test
    void testCreateCourseWithUniqueLesson() {
        // Arrange
        CourseRequestDTO uniqueCourseRequest = new CourseRequestDTO(
            Sport.TENNIS, 
            Level.ADVANCED, 
            PlanType.GROUP, 
            4, 
            LocalTime.of(9, 0), 
            DayOfWeek.MONDAY, 
            null, 
            true,  // uniqueLesson is true
            1L, 
            1L, 
            new Long[] {1L, 2L, 3L, 4L}
        );

        CourseEntity courseEntity = new CourseEntity();
        when(courseRepository.save(any(CourseEntity.class))).thenReturn(courseEntity);
        when(teacherRepository.findById(anyLong())).thenReturn(java.util.Optional.of(new TeacherEntity()));

        // Act
        Long courseId = courseService.create(uniqueCourseRequest);

        // Assert
        assertNotNull(courseId);
        verify(lessonService, times(1)).createUniqueLesson(any(CourseEntity.class));
    }
}


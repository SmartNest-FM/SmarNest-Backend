package com.smartnest.SmartNest.controller;

import com.smartnest.SmartNest.model.*;
import com.smartnest.SmartNest.model.dto.ProgressResponse;
import com.smartnest.SmartNest.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.smartnest.SmartNest.model.dto.ActivityStatusResponse;
import com.smartnest.SmartNest.model.dto.LevelProgressResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/progress")
public class UserActivityProgressController {

    @Autowired private UserService userService;
    @Autowired private UserActivityProgressService progressService;

    @Autowired private PhonologicalAwarenessService phonologicalService;
    @Autowired private ReadingComprehensionService readingService;
    @Autowired private FluentReadingService fluentService;
    @Autowired private VocabularyVerbService vocabularyService;
    @Autowired private CombinationReadingImagesService combinationService;
    @Autowired private LevelService levelService;

    // --------------------------------------------
    // 1. PHONOLOGICAL AWARENESS
    // --------------------------------------------
    @PostMapping("/phonological/{activityId}")
    public ResponseEntity<?> completePhonological(
            @PathVariable int activityId,
            @RequestParam String uid,
            @RequestParam int score) {

        User user = userService.getUserByUid(uid);
        if (user == null) return ResponseEntity.status(404).body("User not found");

        if (progressService.existsByUserAndActivity(uid, activityId, "PHONOLOGICAL")) {
            return ResponseEntity.ok("Already completed");
        }

        PhonologicalAwareness activity = phonologicalService.getPhonologicalAwarenessById(activityId);

        UserActivityProgress progress = new UserActivityProgress();
        progress.setUser(user);
        progress.setActivityId(activityId);
        progress.setActivityType("PHONOLOGICAL");
        progress.setCompleted(true);
        progress.setScore(score);
        progress.setLevelId(activity.getLevel().getId());

        progressService.save(progress);

        return ResponseEntity.ok("Phonological progress saved");
    }

    // --------------------------------------------
    // 2. READING COMPREHENSION
    // --------------------------------------------
    @PostMapping("/reading/{activityId}")
    public ResponseEntity<?> completeReading(
            @PathVariable int activityId,
            @RequestParam String uid,
            @RequestParam int score) {

        User user = userService.getUserByUid(uid);
        if (user == null) return ResponseEntity.status(404).body("User not found");

        if (progressService.existsByUserAndActivity(uid, activityId, "READING")) {
            return ResponseEntity.ok("Already completed");
        }

        ReadingComprehension activity = readingService.getReadingComprehensionById(activityId);

        UserActivityProgress progress = new UserActivityProgress();
        progress.setUser(user);
        progress.setActivityId(activityId);
        progress.setActivityType("READING");
        progress.setCompleted(true);
        progress.setScore(score);
        progress.setLevelId(activity.getLevel().getId());

        progressService.save(progress);

        return ResponseEntity.ok("Reading progress saved");
    }

    // --------------------------------------------
    // 3. FLUENT READING
    // --------------------------------------------
    @PostMapping("/fluent/{activityId}")
    public ResponseEntity<?> completeFluent(
            @PathVariable int activityId,
            @RequestParam String uid,
            @RequestParam int score) {

        User user = userService.getUserByUid(uid);
        if (user == null) return ResponseEntity.status(404).body("User not found");

        if (progressService.existsByUserAndActivity(uid, activityId, "FLUENT")) {
            return ResponseEntity.ok("Already completed");
        }

        FluentReading activity = fluentService.getFluentReadingById(activityId);

        UserActivityProgress progress = new UserActivityProgress();
        progress.setUser(user);
        progress.setActivityId(activityId);
        progress.setActivityType("FLUENT");
        progress.setCompleted(true);
        progress.setScore(score);
        progress.setLevelId(activity.getLevel().getId());

        progressService.save(progress);

        return ResponseEntity.ok("Fluent progress saved");
    }

    // --------------------------------------------
    // 4. VOCABULARY & VERBS
    // --------------------------------------------
    @PostMapping("/vocabulary/{activityId}")
    public ResponseEntity<?> completeVocabulary(
            @PathVariable int activityId,
            @RequestParam String uid,
            @RequestParam int score) {

        User user = userService.getUserByUid(uid);
        if (user == null) return ResponseEntity.status(404).body("User not found");

        if (progressService.existsByUserAndActivity(uid, activityId, "VOCABULARY")) {
            return ResponseEntity.ok("Already completed");
        }

        VocabularyVerb activity = vocabularyService.getVocabularyVerbById(activityId);

        UserActivityProgress progress = new UserActivityProgress();
        progress.setUser(user);
        progress.setActivityId(activityId);
        progress.setActivityType("VOCABULARY");
        progress.setCompleted(true);
        progress.setScore(score);
        progress.setLevelId(activity.getLevel().getId());

        progressService.save(progress);

        return ResponseEntity.ok("Vocabulary progress saved");
    }

    // --------------------------------------------
    // 5. COMBINATION READING & IMAGES
    // --------------------------------------------
    @PostMapping("/combination/{activityId}")
    public ResponseEntity<?> completeCombination(
            @PathVariable int activityId,
            @RequestParam String uid,
            @RequestParam int score) {

        User user = userService.getUserByUid(uid);
        if (user == null) return ResponseEntity.status(404).body("User not found");

        if (progressService.existsByUserAndActivity(uid, activityId, "COMBINATION")) {
            return ResponseEntity.ok("Already completed");
        }

        CombinationReadingImages activity = combinationService.getCombinationReadingImagesById(activityId);

        UserActivityProgress progress = new UserActivityProgress();
        progress.setUser(user);
        progress.setActivityId(activityId);
        progress.setActivityType("COMBINATION");
        progress.setCompleted(true);
        progress.setScore(score);
        progress.setLevelId(activity.getLevel().getId());

        progressService.save(progress);

        return ResponseEntity.ok("Combination progress saved");
    }

    @GetMapping("/percentage/{levelId}")
    public ResponseEntity<?> getUserProgressPercentage(
            @PathVariable int levelId,
            @RequestParam String uid) {

        // 1. Obtener progreso del usuario para este nivel
        List<UserActivityProgress> userProgress =
                progressService.getProgressByUserUidAndLevel(uid, levelId);

        int completedActivities = userProgress.size();

        // 2. Obtener todas las actividades del nivel
        int totalActivities = 0;

        // PHONOLOGICAL
        totalActivities += phonologicalService.getAllPhonologicalAwareness()
                .stream()
                .filter(a -> a.getLevel().getId() == levelId)
                .count();

        // READING COMPREHENSION
        totalActivities += readingService.getAllReadingComprehensions()
                .stream()
                .filter(a -> a.getLevel().getId() == levelId)
                .count();

        // FLUENT
        totalActivities += fluentService.getAllFluentReadings()
                .stream()
                .filter(a -> a.getLevel().getId() == levelId)
                .count();

        // VOCABULARY & VERBS
        totalActivities += vocabularyService.getAllVocabularyVerbs()
                .stream()
                .filter(a -> a.getLevel().getId() == levelId)
                .count();

        // COMBINATION
        totalActivities += combinationService.getAllCombinationReadingImages()
                .stream()
                .filter(a -> a.getLevel().getId() == levelId)
                .count();

        if (totalActivities == 0) {
            return ResponseEntity.ok("Level has no activities");
        }

        // 3. Calcular porcentaje
        double percentage = (completedActivities / (double) totalActivities) * 100.0;

        ProgressResponse response =
                new ProgressResponse(totalActivities, completedActivities, percentage);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/levels")
    public ResponseEntity<?> getAllLevelsProgress(@RequestParam String uid) {

        // 1. Obtiene todos los niveles del sistema
        List<Level> levels = levelService.getAllLevels();

        List<LevelProgressResponse> responseList = new ArrayList<>();

        for (Level level : levels) {

            int levelId = level.getId();

            // 2. Actividades completadas por el usuario en este nivel
            List<UserActivityProgress> completed =
                    progressService.getProgressByUserUidAndLevel(uid, levelId);
            int completedActivities = completed.size();

            // 3. Obtener total de actividades del nivel
            int totalActivities = 0;

            // PHONOLOGICAL
            totalActivities += phonologicalService.getAllPhonologicalAwareness()
                    .stream()
                    .filter(a -> a.getLevel().getId() == levelId)
                    .count();

            // READING
            totalActivities += readingService.getAllReadingComprehensions()
                    .stream()
                    .filter(a -> a.getLevel().getId() == levelId)
                    .count();

            // FLUENT
            totalActivities += fluentService.getAllFluentReadings()
                    .stream()
                    .filter(a -> a.getLevel().getId() == levelId)
                    .count();

            // VOCABULARY
            totalActivities += vocabularyService.getAllVocabularyVerbs()
                    .stream()
                    .filter(a -> a.getLevel().getId() == levelId)
                    .count();

            // COMBINATION
            totalActivities += combinationService.getAllCombinationReadingImages()
                    .stream()
                    .filter(a -> a.getLevel().getId() == levelId)
                    .count();

            // 4. Calcular porcentaje
            double percentage = (totalActivities == 0)
                    ? 0
                    : (completedActivities / (double) totalActivities) * 100;

            // 5. Agregar al response
            LevelProgressResponse dto =
                    new LevelProgressResponse(levelId, level.getName(),
                            totalActivities, completedActivities, percentage);

            responseList.add(dto);
        }

        return ResponseEntity.ok(responseList);
    }

    @GetMapping("/status/{activityType}/{activityId}")
        public ResponseEntity<?> getActivityStatus(
                @PathVariable String activityType,
                @PathVariable int activityId,
                @RequestParam String uid) {

        boolean completed = progressService.isActivityCompleted(uid, activityId, activityType);

        ActivityStatusResponse res = new ActivityStatusResponse(completed);

        return ResponseEntity.ok(res);
        }

}

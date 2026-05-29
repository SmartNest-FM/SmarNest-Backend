package com.smartnest.SmartNest.model.dto;

public class AiEvaluateResponse {

    /** "correct", "partial" o "wrong" */
    private String verdict;

    /** Mensaje pedagógico para mostrar al niño */
    private String message;

    /** Puntuación 0..100 para guardar en progreso */
    private int scorePercentage;

    /** Desglose de métricas individuales */
    private ScoresDto scores;

    public String getVerdict() { return verdict; }
    public void setVerdict(String verdict) { this.verdict = verdict; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public int getScorePercentage() { return scorePercentage; }
    public void setScorePercentage(int scorePercentage) { this.scorePercentage = scorePercentage; }

    public ScoresDto getScores() { return scores; }
    public void setScores(ScoresDto scores) { this.scores = scores; }

    public static class ScoresDto {
        private double semantic;
        private double lexical;
        private double phonetic;
        private double finalScore;

        public double getSemantic() { return semantic; }
        public void setSemantic(double semantic) { this.semantic = semantic; }

        public double getLexical() { return lexical; }
        public void setLexical(double lexical) { this.lexical = lexical; }

        public double getPhonetic() { return phonetic; }
        public void setPhonetic(double phonetic) { this.phonetic = phonetic; }

        public double getFinalScore() { return finalScore; }
        public void setFinalScore(double finalScore) { this.finalScore = finalScore; }
    }
}

package cn.iocoder.yudao.module.assistant.service.message;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AssistantSseParserTest {

    @Test
    void parsesThinkingContentAndDoneFrames() {
        AssistantSseParser.FrameAssembler assembler = new AssistantSseParser.FrameAssembler();
        List<AssistantSseParser.Chunk> chunks = new ArrayList<>();
        chunks.addAll(assembler.acceptLine("event: thinking"));
        chunks.addAll(assembler.acceptLine("data: {\"delta\":\"先看\"}"));
        chunks.addAll(assembler.acceptLine(""));
        chunks.addAll(assembler.acceptLine("event: content"));
        chunks.addAll(assembler.acceptLine("data: \"正文\""));
        chunks.addAll(assembler.acceptLine(""));
        chunks.addAll(assembler.acceptLine("event: done"));
        chunks.addAll(assembler.acceptLine("data: {}"));
        chunks.addAll(assembler.acceptLine(""));

        assertEquals(3, chunks.size());
        assertEquals(AssistantSseParser.Kind.THINKING, chunks.get(0).getKind());
        assertEquals("先看", chunks.get(0).getText());
        assertEquals(AssistantSseParser.Kind.CONTENT, chunks.get(1).getKind());
        assertEquals("正文", chunks.get(1).getText());
        assertEquals(AssistantSseParser.Kind.DONE, chunks.get(2).getKind());
    }

    @Test
    void parsesOpenAiChunk() {
        String data = "{\"choices\":[{\"delta\":{\"reasoning_content\":\"想\",\"content\":\"答\"},\"finish_reason\":\"stop\"}]}";
        List<AssistantSseParser.Chunk> chunks = AssistantSseParser.parseEvent("message", data);
        assertEquals(3, chunks.size());
        assertEquals(AssistantSseParser.Kind.THINKING, chunks.get(0).getKind());
        assertEquals("想", chunks.get(0).getText());
        assertEquals(AssistantSseParser.Kind.CONTENT, chunks.get(1).getKind());
        assertEquals("答", chunks.get(1).getText());
        assertEquals(AssistantSseParser.Kind.DONE, chunks.get(2).getKind());
    }

    @Test
    void parsesErrorMessage() {
        List<AssistantSseParser.Chunk> chunks = AssistantSseParser.parseEvent("error", "{\"message\":\"算法忙\"}");
        assertEquals(1, chunks.size());
        assertEquals(AssistantSseParser.Kind.ERROR, chunks.get(0).getKind());
        assertEquals("算法忙", chunks.get(0).getText());
        assertTrue(AssistantSseParser.parseEvent("message", "[DONE]").get(0).getKind() == AssistantSseParser.Kind.DONE);
    }

}

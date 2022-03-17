package payloads;

public class InvalidPayloads {

    public String payloadWithoutCurlyBracesJson(){
        return "{\n" +
                "    \"properties1\": \"value1\",\n" +
                "    \"properties2\": \"value2\"\n" +
                "";
    }

    public String payloadWithoutColonJson(){
        return "{\n" +
                "    \"properties1\": \"value1\",\n" +
                "    \"properties2\" \"value2\"\n" +
                "}";
    }

    public String payloadWithoutCommaJson(){
        return "{\n" +
                "    \"properties1\": \"value1\"\n" +
                "    \"properties2\": \"value2\"\n" +
                "}";
    }
}
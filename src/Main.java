void main() {
    Base64Encoder base64Encoder = new Base64Encoder();

    int input = 1234567;
    String encoded = base64Encoder.encode(input);
    int decoded = base64Encoder.decode(encoded);

    assert (input == decoded);
}

Feature: Chat API

  @smoke @regression
  Scenario: Server responds with a 200 OK for a valid stream request
    Given the user has a valid authorization token
    When the user sends a valid stream request to the chat
    Then the user receives a successful stream response with a 200 OK and the correct content

  @smoke @regression
  Scenario: Server responses with a 200 OK for a valid non-stream request
    Given the user has a valid authorization token
    When the user sends a valid non-stream request to the chat
    Then the user receives a successful non-stream response with a 200 OK and the correct content

  @regression
  Scenario: Server responses with a 401 Unauthorized for a request with an invalid authorization token
    Given the user has an invalid authorization token
    When the user sends a valid non-stream request to the chat
    Then the user receives a client error response with a 401 Unauthorized and the error message

  @regression
  Scenario: Server responses with a 400 Bad Request for a request without a mandatory field
    Given the user has a valid authorization token
    When the user sends an invalid non-stream request to the chat without a mandatory field
    Then the user receives a client error response with a 400 Bad Request and the error message

  @regression
  Scenario: Server responses with a 500 Internal Server Error for a malformed request
    Given the user has a valid authorization token
    When the user sends a malformed request to the chat
    Then the user receives a server error response with a 500 Internal Server Error and the error message

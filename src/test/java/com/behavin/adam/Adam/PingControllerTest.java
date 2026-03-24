package com.behavin.adam.Adam;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(PingController.class)
class PingControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void pingReturnsPongWithFormattedDateTime() throws Exception {
		mockMvc.perform(get("/ping"))
			.andExpect(status().isOk())
			.andExpect(content().string(org.hamcrest.Matchers.matchesPattern(
				"pong \\d{2}\\.\\d{2}\\.\\d{4} \\d{2}:\\d{2}:\\d{2}")));
	}
}

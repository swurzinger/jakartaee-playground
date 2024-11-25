package org.eclipse.jakarta.hello;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(name = "HelloDescriptor", description = "Greeter describing whom to say hello to")
public class Hello {

	private String name;

	public Hello(String name) {
        this.name = name;
	}

	public String getHello(){
		return name;
	}
}

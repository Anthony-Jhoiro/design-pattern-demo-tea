package org.fges.notes.tea;

/**
 * Our application domain. Its role is only to make it easy to create.
 *
 * @param name      name of the tea
 * @param imageLink url or relative path to an image
 */
public record Tea(String name, String imageLink) {
}

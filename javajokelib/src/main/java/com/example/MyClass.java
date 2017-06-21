package com.example;

import java.util.Random;

public class MyClass {
    private static final String[] jokes ={"Why do dogs always race to the door when the doorbell rings? It’s hardly ever for them.",
            "Nature abhors a vacuum, but not as much as a cat does.",
            "I dressed my dog up as a cat for Halloween. Now he won’t come when I call him.",
            "What do you call an Amish guy with his hand in a horse’s mouth?\n" +

                    "A: A mechanic.",
                    "My cat just walked up to the paper shredder and said, “Teach me \u2028everything you know.”\n" +
                            "\n",
            "What should you do when \u2028you see an endangered animal \u2028eating an endangered plant?\n" +
                    "\n"};

    public static String getAJoke(){

        int size = jokes.length;
        Random random = new Random();
        int index = random.nextInt(size);
        return jokes[index];
    }
}

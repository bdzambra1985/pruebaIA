package com.example.backpackstore;

import java.util.ArrayList;
import java.util.List;

public class MockProductRepository {

    private static List<Backpack> backpacks = null;

    public static List<Backpack> getBackpacks() {
        if (backpacks == null) {
            backpacks = new ArrayList<>();
            // Add sample backpacks
            backpacks.add(new Backpack(
                    "bp001",
                    "Adventure Pro Backpack",
                    "A durable and spacious backpack perfect for all your adventures. Features multiple compartments and water-resistant material. Enjoy a 360 view!",
                    79.99,
                    "backpack_360_sample.jpg" // Referring to the placeholder asset
            ));
            backpacks.add(new Backpack(
                    "bp002",
                    "Urban Commuter Pack",
                    "Sleek and stylish, this backpack is designed for the modern city dweller. Lightweight with a dedicated laptop sleeve. Check out the 360 view.",
                    59.99,
                    "placeholder_360_urban.jpg" // Assuming another placeholder or the same one for now
            ));
            backpacks.add(new Backpack(
                    "bp003",
                    "Trailblazer Hiking Bag",
                    "Built for the rugged outdoors, this hiking bag offers comfort and capacity. Includes hydration pack compatibility. See it from all angles (360 view)!",
                    99.99,
                    "placeholder_360_hiking.jpg" // Assuming another placeholder or the same one
            ));
        }
        return backpacks;
    }

    public static Backpack getBackpackById(String id) {
        for (Backpack backpack : getBackpacks()) {
            if (backpack.getId().equals(id)) {
                return backpack;
            }
        }
        return null;
    }
}

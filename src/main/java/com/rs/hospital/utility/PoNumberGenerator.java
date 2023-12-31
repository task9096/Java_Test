package com.rs.hospital.utility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class PoNumberGenerator {
    public static String generatePoNumber() {
        // Define a prefix for your PO number
        String prefix = "PO";

        // Generate a unique identifier
        //String uniqueId = UUID.randomUUID().toString().replace("-", "");

        // Get the current timestamp
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

        // Combine the prefix, timestamp, and unique identifier to create the PO number
        String poNumber = prefix + timestamp ;

        return poNumber;
    }

    public static String generateInvoiceNumber() {
        // Define a prefix for your PO number
        String prefix = "IN";

        // Generate a unique identifier
        //String uniqueId = UUID.randomUUID().toString().replace("-", "");

        // Get the current timestamp
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

        // Combine the prefix, timestamp, and unique identifier to create the PO number
        String poNumber = prefix + timestamp ;

        return poNumber;
    }

    public static String generateUpFrontInvoiceNumber() {
        // Define a prefix for your PO number
        String prefix = "UFN";

        // Generate a unique identifier
        //String uniqueId = UUID.randomUUID().toString().replace("-", "");

        // Get the current timestamp
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

        // Combine the prefix, timestamp, and unique identifier to create the PO number
        String poNumber = prefix + timestamp ;

        return poNumber;
    }
}

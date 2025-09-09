package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private int age;
	
	// check this piece of code
//	public JSONObject whatsappJSONBuilderNew(String templateId, String jsonString, Map<String, ?> placeholders, String leadUsername,String leadPhoneNumber ) {
//		JSONObject job = new JSONObject();
//		JSONObject job2 = new JSONObject();
//		
//		job.put("dispatch_action", templateId);
//		
//		job2 = replaceAndChange(jsonString, placeholders, leadUsername, leadPhoneNumber);
//		
//		if(!job2.isEmpty())
//			job.put("dispatch_payload", job2);
//		
//		return job;
//	}
// 
// private static final Object UNRESOLVED = new Object();
// 
// public static JSONObject replaceAndChange(String jsonString,Map<String, ?> placeholders,String leadUsername,String leadPhoneNumber) {
//		JSON json = JSONSerializer.toJSON(jsonString);
//		Object replaced = replaceVal(json, placeholders);
//		
//		final JSONObject out = (replaced instanceof JSONObject)
//                ? (JSONObject) replaced
//                : new JSONObject().element("data", replaced);
////		if (replaced instanceof JSONObject) {
////		out = (JSONObject) replaced;
////		} else {
////		out = new JSONObject();
//////		out.put("data", replaced);
////		}
//		
//		out.put("lead_username", leadUsername);
//		out.put("lead_phonenumber", leadPhoneNumber);
//		return out;
// }
 
// private static Object replaceVal(Object node, Map<String, ?> placeholders) {
//	 if (node == null || node == JSONNull.getInstance()) return node;
//
//        if (node instanceof JSONObject) {
//            JSONObject obj = (JSONObject) node;
//            List<String> keys = new ArrayList<>();
//            for (Object k : obj.keySet()) keys.add((String) k);
//
//            for (String key : keys) {
//                Object child = obj.get(key);
//                Object newVal = replaceVal(child, placeholders);
//
//                if (newVal == UNRESOLVED) {
//                    obj.put(key, "");
//                } else {
//                    obj.put(key, newVal);
//                }
//            }
//            return obj;
//        }
//
//        if (node instanceof JSONArray) {
//            JSONArray arr = (JSONArray) node;
//            for (int i = 0; i < arr.size(); i++) {
//                Object elem = arr.get(i);
//                Object newVal = replaceVal(elem, placeholders);
//                arr.set(i, newVal == UNRESOLVED ? "" : newVal);
//            }
//            return arr;
//        }
//
//        if (node instanceof String) {
//            String s = (String) node;
//            if (isBracketed(s)) {
//                if (placeholders.containsKey(s)) {
//                    return toJSONVal(placeholders.get(s));
//                } else {
//                    return UNRESOLVED;
//                }
//            }
//        }
//
//        return node;
//    }
//
//    private static boolean isBracketed(String s) {
//        return s != null && s.length() >= 3 && s.charAt(0) == '[' && s.charAt(s.length() - 1) == ']';
//    }
//
//    private static Object toJSONVal(Object val) {
//        if (val == null) return JSONNull.getInstance();
//        if (val instanceof JSONObject || val instanceof JSONArray) return val;
//        if (val instanceof Map || val instanceof Collection) return JSONSerializer.toJSON(val);
//        return val;
//    }
	
}

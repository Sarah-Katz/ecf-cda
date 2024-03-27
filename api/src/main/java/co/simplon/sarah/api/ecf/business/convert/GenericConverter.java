package co.simplon.sarah.api.ecf.business.convert;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class GenericConverter {
    private static GenericConverter instance;

    /**
     * @return an instance of the GenericConvert class
     */
    public static GenericConverter getInstance() {
        if (instance == null) {
            instance = new GenericConverter();
        }
        return instance;
    }

    /**
     * 
     * @param <T>   any Class extending Object
     * @param clazz the class of the conversion output
     * @return a new instance of the conversion output
     * @throws GenericConverterException
     */
    private <T extends Object> T instantiateOutput(final Class<T> clazz) throws GenericConverterException {
        try {
            return clazz.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            throw new GenericConverterException("Error instantiating the desired output class", e);
        }
    }

    /**
     * @param <T>   any Class extending Object
     * @param clazz the class of the conversion output
     * @return a map of getter methods for the conversion output
     */
    private <T extends Object> Map<String, Method> mapOutputMethods(final Class<T> clazz) {
        final Map<String, Method> outputMethods = new HashMap<>();
        for (final Method method : clazz.getDeclaredMethods()) {
            if (method.getName().startsWith("set") && method.getParameterTypes().length == 1) {
                outputMethods.put(method.getName().substring(3), method);
            }
        }
        return outputMethods;
    }

    /**
     * Converts an input of any class to it's corresponding output (input and output
     * MUST have the same getters and setters)
     * 
     * @param <T1>  any instantiated Class
     * @param <T2>  any Class extending Object
     * @param input the instantiated input to convert
     * @param clazz the class of the conversion output
     * @return a new instance of the conversion output
     * @throws GenericConverterException
     */
    public <T1, T2 extends Object> T2 convert(final T1 input, final Class<T2> clazz) throws GenericConverterException {
        final T2 output = instantiateOutput(clazz);
        final Map<String, Method> outputMethods = mapOutputMethods(clazz);
        for (final Map.Entry<String, Method> entry : outputMethods.entrySet()) {
            final String getterName = "get" + entry.getKey().substring(0, 1).toUpperCase()
                    + entry.getKey().substring(1);
            Method getterMethod;
            try {
                getterMethod = input.getClass().getMethod(getterName);
                entry.getValue().invoke(output, getterMethod.invoke(input));
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                throw new GenericConverterException("Error setting an attribute during conversion", e);
            }
        }
        return output;
    }

    /**
     * Converts a list of inputs of any class to a list of corresponding outputs
     * (inputs and outputs MUST have the same getters and setters)
     * 
     * @param <T1>      any instantiated Class
     * @param <T2>      any Class extending Object
     * @param inputList the {@List list} of instantiated inputs to convert
     * @param clazz     the class of the conversion output
     * @return a list of new instances of the conversion output
     * @throws GenericConverterException
     */
    public <T1, T2 extends Object> List<T2> convertList(final List<T1> inputList, final Class<T2> clazz)
            throws GenericConverterException {
        final List<T2> outputList = new ArrayList<>();
        for (final T1 input : inputList) {
            outputList.add(convert(input, clazz));
        }
        return outputList;
    }

}
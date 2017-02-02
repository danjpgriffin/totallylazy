package com.googlecode.totallylazy;

//import com.googlecode.totallylazy.iterators.NodeIterator;
//import com.googlecode.totallylazy.iterators.PoppingIterator;
import com.googlecode.totallylazy.predicates.LogicalPredicate;
import org.w3c.dom.Attr;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.transform.Source;


public class Xml {
    public static String selectContents(final Node node, final String expression) {
        throw new RuntimeException("DAN");
        //return contents(internalSelectNodes(node, expression));
    }
//
    public static Sequence<Node> selectNodes(final Node node, final String expression) {
        throw new RuntimeException("DAN");
        //return internalSelectNodes(node, expression);
    }

    public static Option<Node> selectNode(final Node node, final String expression) {
        throw new RuntimeException("DAN");
        //return selectNodes(node, expression).headOption();
    }
//
    public static Sequence<Element> selectElements(final Node node, final String expression) {
        return selectNodes(node, expression).safeCast(Element.class);
    }

    public static Option<Element> selectElement(final Node node, final String expression) {
        throw new RuntimeException("DAN");
        //return selectElements(node, expression).headOption();
    }

    public static Sequence<Node> sequence(final NodeList nodes) {
        throw new RuntimeException("DAN");
//        return new Sequence<Node>() {
//            public Iterator<Node> iterator() {
//                return new NodeIterator(nodes);
//            }
//        };
    }
//
    public static String contents(Sequence<Node> nodes) {
        throw new RuntimeException("DAN");
        //return contentsSequence(nodes).toString("");
    }

    public static String contents(Node node) throws Exception {
        if (node instanceof Attr) {
            return contents((Attr) node);
        }
        if (node instanceof CharacterData) {
            return contents((CharacterData) node);
        }
        if (node instanceof Element) {
            return contents((Element) node);
        }
        throw new UnsupportedOperationException("Unknown node type " + node.getClass());
    }

    public static String asString(Node node) throws Exception {
        throw new RuntimeException("DAN");
        //return asString(node, true);
    }

    public static Document document(byte[] bytes) {
        throw new RuntimeException("DAN");
        //return document(new InputSource(new ByteArrayInputStream(bytes)));
    }
//
    public static Document document(String xml) {
        throw new RuntimeException("DAN");
        //return document(new InputSource(new StringReader(xml)));
    }
//
    public static Document document(InputSource inputSource) {
        throw new RuntimeException("DAN");

    }

    public static Source source(final Document document) {
        throw new RuntimeException("DAN");

    }

    public static String escape(Object value) {
        throw new RuntimeException("DAN");
    }

}
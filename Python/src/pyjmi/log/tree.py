#!/usr/bin/env python 
# -*- coding: utf-8 -*-

# Copyright (C) 2013 Modelon AB
#
# This program is free software: you can redistribute it and/or modify
# it under the terms of the GNU Lesser General Public License as published by
# the Free Software Foundation, version 3 of the License.
#
# This program is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
# GNU Lesser General Public License for more details.
#
# You should have received a copy of the GNU Lesser General Public License
# along with this program. If not, see <http://www.gnu.org/licenses/>.
"""
Tree representation for the new FMU log format

Each node is represented as a NamedNode, Comment, string, list, or NamedNodeList
"""

class NamedNode(object):
    """Named log node.

    Attributes:
    name  -- a string
    value -- a list for long nodes `name( ... )name`
             a value for short nodes `name=value`
    """    
    def __init__(self, name, value):
        assert isinstance(name, str)
        self.name = name
        self.value = value

    def __repr__(self):
        return self.name + "( " + repr(self.value) + " )"

class Comment(object):
    """Log comment node.

    Attributes:
    text -- the comment text without enclosing braces {}
    """
    def __init__(self, text):
        assert isinstance(text, str)
        self.text = text

    def __repr__(self):
        return "{" + self.text + "}"

class NamedNodeList(object):
    """List of NamedNode and Comment objects."""
    def __init__(self, nodes):
        assert isinstance(nodes, list)
        self.nodes = nodes

    def __repr__(self):        
        return repr(tuple(self.nodes))

    def __iter__(self):
        return iter(self.nodes)

    def __getitem__(self, key):
        return self.nodes[key]
